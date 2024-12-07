// INFO: CLIENT-SIDE CLASS TO GET THE PLAYER POSITION AND PLAY A SOUND WHEN NECESSARY \\

package wonnd3r.dev.sound;

import net.minecraft.client.sound.PositionedSoundInstance;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class CaveSoundPlayer {
    private long lastCheckTime = 0;
    private boolean oneTimeSound = false;

    public void registerPositionLogger() {

        // Checking all conditions
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null && client.player != null && !client.player.isSpectator()) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastCheckTime >= 1) {
                    BlockPos pos = client.player.getBlockPos();

                    // Play ambient sound
                    updateSoundState(client);
                    if (pos.getY() <= 0) {
                        playSound_ambient1(client, pos);
                    } else {
                        stopSound_ambient1(client);
                    }

                    // Initial sound
                    if (pos.getY() <= 5 && oneTimeSound == false) {
                        int randomNumber = new Random().nextInt(10) + 1;
                        switch (randomNumber) {
                            case 1: playSound_rubius_voice1(client, pos); break;
                            case 2: playSound_bang1(client, pos); break;
                            case 3: playSound_tock1(client, pos); break;
                            case 4: playSound_head1(client, pos); break;
                            case 5: playSound_move1(client, pos); break;
                            case 6: playSound_fall1(client, pos); break;
                            case 7: playSound_fall2(client, pos); break;
                            case 8: playSound_rock1(client, pos); break;
                            case 9: playSound_rock2(client, pos); break;
                            case 10: playSound_whistle1(client, pos); break;
                        }
                        oneTimeSound = true;
                    }

                    // General sounds
                    if (pos.getY() <= 0) {
                        int randomNumber = new Random().nextInt(40000);
                        if (randomNumber == 1) playSound_rubius_voice1(client, pos);
                        else if (randomNumber == 2) playSound_bang1(client, pos);
                        else if (randomNumber == 3) playSound_tock1(client, pos);
                        else if (randomNumber == 4) playSound_head1(client, pos);
                        else if (randomNumber == 5) playSound_move1(client, pos);
                        else if (randomNumber == 6) playSound_fall1(client, pos);
                        else if (randomNumber == 7) playSound_fall2(client, pos);
                        else if (randomNumber == 8) playSound_rock1(client, pos);
                        else if (randomNumber == 9) playSound_rock2(client, pos);
                        else if (randomNumber == 10) playSound_whistle1(client, pos);
                    }

                    // Diamond mining audio (NO USE)
                    int randomNumber = new Random().nextInt(70000);
                    if (pos.getY() >= -59 && pos.getY() <= -48 && randomNumber == 1) {
                        playSound_whistle1(client, pos);
                    }

                    // Low-probalility morse-encoded sounds
                    if (pos.getY() <= 0) {
                        int randomNumber3 = new Random().nextInt(90000);
                        switch (randomNumber3) {
                            case 1: playSound_morse1(client, pos); break;
                            case 2: playSound_morse2(client, pos); break;
                        }
                    }
                    lastCheckTime = currentTime;
                }
            }
        });
    }

    // Play the sound
    private void playSound_rubius_voice1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.RUBIUS_VOICE1_EVENT, 1.0F, 0.9F));
    }
    private void playSound_bang1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.BANG1_EVENT, 1.0F, 0.5F));
    }
    private void playSound_tock1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.TOCK1_EVENT, 1.0F, 1.0F));
    }

    // Special ambient play/stop
    private boolean isAmbientPlaying = false;
    private PositionedSoundInstance ambientSoundInstance;

    private void playSound_ambient1(MinecraftClient client, BlockPos pos) {
        if (!isAmbientPlaying) {
            isAmbientPlaying = true;
            ambientSoundInstance = PositionedSoundInstance.master(SoundsRegister.AMBIENT2_EVENT, 1.0F, 0.9F);
            client.getSoundManager().play(ambientSoundInstance);
        }
    }
    private void updateSoundState(MinecraftClient client) {
        if (ambientSoundInstance != null && !client.getSoundManager().isPlaying(ambientSoundInstance)) {
            isAmbientPlaying = false;
        }
    }
    private void stopSound_ambient1(MinecraftClient client) {
        isAmbientPlaying = false;
        client.getSoundManager().stop(ambientSoundInstance);
    }

    private void playSound_morse1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.MORSE1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_morse2(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.MORSE2_EVENT, 1.0F, 1.0F));
    }
    private void playSound_head1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.HEAD1_EVENT, 1.0F, 0.8F));
    }
    private void playSound_move1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.MOVE1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_fall1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.FALL1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_fall2(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.FALL2_EVENT, 1.0F, 1.0F));
    }
    private void playSound_rock1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.ROCK1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_rock2(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.ROCK2_EVENT, 1.0F, 1.0F));
    }
    private void playSound_whistle1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.WHISTLE1_EVENT, 1.0F, 1.0F));
    }
}
