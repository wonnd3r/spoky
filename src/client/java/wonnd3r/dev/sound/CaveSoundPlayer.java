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

    public void registerPositionLogger() {

        // Checking all the conditions
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null && client.player != null && !client.player.isSpectator()) {
                long currentTime = System.nanoTime();
                if (currentTime - lastCheckTime >= 1) {
                    BlockPos pos = client.player.getBlockPos();

                    // Play ambient sound
                    updateSoundState(client);
                    if (pos.getY() <= 0) {
                        playSound_ambient1(client, pos);
                    } else {
                        stopSound_ambient1(client);
                    }

                    // First sound fase
                    if (pos.getY() <= 0) {
                        Random r = new Random();
                        int randomNumber = r.nextInt(50000);
                        if (randomNumber == 1) {
                            playSound_rubius_voice1(client, pos);
                        } if (randomNumber == 2) {
                            playSound_bang1(client, pos);
                        } if (randomNumber == 3) {
                            playSound_dry_hands_intro(client, pos);
                        } if (randomNumber == 4) {
                            playSound_tock1(client, pos);
                        } if (randomNumber == 5) {
                            playSound_head1(client, pos);
                        } if (randomNumber == 6) {
                            playSound_move1(client, pos);
                        }
                    }

                    // Second sound fase
                    Random r2 = new Random();
                    int randomNumber2 = r2.nextInt(70000);
                    if (pos.getY() >= -59 && pos.getY() <= -48 && randomNumber2 == 1) {
                        playSound_wet_hands(client, pos);
                    } if (pos.getY() >= -59 && pos.getY() <= -48 && randomNumber2 >= 295) {
                        playSound_dry_hands_intro(client, pos);
                    }

                    // Third sound fase
                    if (pos.getY() <= 0) {
                        Random r3 = new Random();
                        int randomNumber3 = r3.nextInt(90000);
                        if (randomNumber3 == 1) {
                            playSound_morse1(client, pos);
                        } if (randomNumber3 == 2) {
                            playSound_morse2(client, pos);
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
    private void playSound_dry_hands_intro(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.DRY_HANDS_INTRO_EVENT, 1.0F, 1.2F));
    }
    private void playSound_tock1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.TOCK1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_wet_hands(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.WET_HANDS_EVENT, 1.0F, 1.0F));
    }

    // Special ambient play/stop
    private boolean isAmbientPlaying = false;
    private PositionedSoundInstance ambientSoundInstance;

    private void playSound_ambient1(MinecraftClient client, BlockPos pos) {
        if (!isAmbientPlaying) {
            isAmbientPlaying = true;
            ambientSoundInstance = PositionedSoundInstance.master(SoundsRegister.AMBIENT2_EVENT, 1.0F, 1.0F);
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
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.HEAD1_EVENT, 1.0F, 1.0F));
    }
    private void playSound_move1(MinecraftClient client, BlockPos pos) {
        client.getSoundManager().play(PositionedSoundInstance.master(SoundsRegister.MOVE1_EVENT, 1.0F, 1.0F));
    }
}
