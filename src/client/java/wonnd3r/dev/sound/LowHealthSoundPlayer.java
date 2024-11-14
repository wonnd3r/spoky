// INFO: CLASS TO PLAY A HEARTBEAT WHEN THE PLAYER IS LOW \\

package wonnd3r.dev.sound;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class LowHealthSoundPlayer {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    int debounce = 0;

    // Run updatePlayerHealth each second
    private void startHealthUpdateScheduler() {
        scheduler.scheduleAtFixedRate(this::updatePlayerHealth, 0, 1, TimeUnit.SECONDS);
    }

    private void updatePlayerHealth() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world != null && client.player != null) {
            float playerHealth = getPlayerHealth(client);
            BlockPos pos = client.player.getBlockPos();
            if (playerHealth <= 4 && debounce == 0) {
                debounce = 1;
                playSound_heart2(client, pos);
            } if (playerHealth >= 4) {
                debounce = 0;
                stopSound_heart(client);
            }
        }
    }

    private float getPlayerHealth(MinecraftClient client) {
        if (client.player != null) {
            PlayerEntity player = client.player;
            return player.getHealth();
        }
        return -1;
    }

    // Register to SpokyClient
    public LowHealthSoundPlayer() {
        startHealthUpdateScheduler();
    }

    //Play the sound and stop it
    private PositionedSoundInstance heartSoundInstance;

    private void playSound_heart2(MinecraftClient client, BlockPos pos) {
        heartSoundInstance = PositionedSoundInstance.master(SoundsRegister.HEART_EVENT, 1.0F, 1.0F);
        client.getSoundManager().play(heartSoundInstance);
    }
    private void stopSound_heart(MinecraftClient client) {
        client.getSoundManager().stop(heartSoundInstance);
    }
}
