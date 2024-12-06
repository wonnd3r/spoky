// INFO: THIS IS THE MAIN CLASS OF THE MOD, USE ONLY FOR IMPORTING OTHER CLASSES \\

package wonnd3r.dev;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("ALL")
public class Spoky implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("Spoky");
	public static final String MOD_ID = "spoky";

	@Override
	public void onInitialize() {

		LOGGER.info("[SPOKY] Initializing...");

	}
}
