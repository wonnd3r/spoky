// INFO: REGISTER AND IMPORT CLIENT-SIDE STUFF \\

package wonnd3r.dev;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import wonnd3r.dev.sound.CaveSoundPlayer;
import wonnd3r.dev.sound.LowHealthSoundPlayer;
import wonnd3r.dev.sound.SoundsRegister;

@SuppressWarnings("ALL")
public class SpokyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		// CaveSoundPlayer.java class
		CaveSoundPlayer playerPosition = new CaveSoundPlayer();
		playerPosition.registerPositionLogger();

		// LowHealthSoundPlayer.java class
		LowHealthSoundPlayer lowHealthSoundPlayer = new LowHealthSoundPlayer();

		// Register all the sounds from the SoundRegister.java class
		SoundsRegister.registerSounds();

	}
}