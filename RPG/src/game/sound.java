package game;

import java.net.URL;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class sound {
    private SourceDataLine sourceLine;
    private AudioInputStream audioInput;

    public void setFile(String path) {
        try {
            URL soundURL = getClass().getResource(path);
            if (soundURL == null) {
                throw new IOException("Audio file not found at: " + path);
            }

            audioInput = AudioSystem.getAudioInputStream(soundURL);
            AudioFormat baseFormat = audioInput.getFormat();

            System.out.println("Loaded Audio Format: " + baseFormat);

            // Convert the format to PCM_SIGNED (16-bit, Little-endian)
            AudioFormat decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2, // 16-bit = 2 bytes per channel
                baseFormat.getSampleRate(),
                false // Little-endian
            );

            audioInput = AudioSystem.getAudioInputStream(decodedFormat, audioInput);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);

            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(decodedFormat);

            System.out.println("Audio loaded successfully.");
        } catch (Exception e) {
            System.err.println("Error loading audio: " + e.getMessage());
        }
    }

    public void play() {
        new Thread(() -> {
            try {
                sourceLine.start();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = audioInput.read(buffer)) != -1) {
                    sourceLine.write(buffer, 0, bytesRead);
                }
                sourceLine.drain();
                sourceLine.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void loop() {
        new Thread(() -> {
            try {
                sourceLine.start();
                byte[] buffer = new byte[4096];
                while (true) {
                    audioInput.mark(0);  // Mark the beginning of the audio
                    int bytesRead;
                    while ((bytesRead = audioInput.read(buffer)) != -1) {
                        sourceLine.write(buffer, 0, bytesRead);
                    }
                    audioInput.reset();  // Restart playback
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stop() {
        if (sourceLine != null) {
            sourceLine.stop();
            sourceLine.flush();
        }
    }

    public void close() {
        if (sourceLine != null) {
            sourceLine.close();
        }
    }
}

