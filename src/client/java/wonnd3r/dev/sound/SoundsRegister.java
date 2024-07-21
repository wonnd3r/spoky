// INFO: CLASS TO REGISTER ALL THE SOUNDS. THE .json FILE IS LOCATED IN THE scr\main\resources\assets\spoky\sounds.json FOLDER \\

package wonnd3r.dev.sound;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

@SuppressWarnings("ALL")
public class SoundsRegister implements ClientModInitializer {

    // rubius_voice1
    public static final Identifier RUBIUS_VOICE1_ID = new Identifier("spoky", "rubius_voice1");
    public static final SoundEvent RUBIUS_VOICE1_EVENT = SoundEvent.of(RUBIUS_VOICE1_ID);

    // bang1
    public static final Identifier BANG1_ID = new Identifier("spoky", "bang1");
    public static final SoundEvent BANG1_EVENT = SoundEvent.of(BANG1_ID);

    // ambient1 [[ THIS SOUND WILL NEVER BE USED SINCE THE MOD "AMBIENT SOUNDS" ALREADY DOES THAT ]]
    public static final Identifier AMBIENT1_ID = new Identifier("spoky", "ambient1");
    public static final SoundEvent AMBIENT1_EVENT = SoundEvent.of(AMBIENT1_ID);

    // dry_hands_intro
    public static final Identifier DRY_HANDS_INTO_ID = new Identifier("spoky", "dry_hands_intro");
    public static final SoundEvent DRY_HANDS_INTRO_EVENT = SoundEvent.of(DRY_HANDS_INTO_ID);

    // heart
    public static final Identifier HEART_ID = new Identifier("spoky", "heart");
    public static final SoundEvent HEART_EVENT = SoundEvent.of(HEART_ID);

    // tock1
    public static final Identifier TOCK1_ID = new Identifier("spoky", "tock1");
    public static final SoundEvent TOCK1_EVENT = SoundEvent.of(TOCK1_ID);

    // tock1_behind [[ THIS SOUND WILL NEVER BE USED SINCE MINECRAFT DOES NOT SUPPORT STEREO SOUNDS ]]
    public static final Identifier TOCK1_BEHIND_ID = new Identifier("spoky", "tock1_behind");
    public static final SoundEvent TOCK1_BEHIND_EVENT = SoundEvent.of(TOCK1_BEHIND_ID);

    // wet_hands
    public static final Identifier WET_HANDS_ID = new Identifier("spoky", "wet_hands");
    public static final SoundEvent WET_HANDS_EVENT = SoundEvent.of(WET_HANDS_ID);

    // morse1
    public static final Identifier MORSE1_ID = new Identifier("spoky", "morse1");
    public static final SoundEvent MORSE1_EVENT = SoundEvent.of(MORSE1_ID);

    // morse2
    public static final Identifier MORSE2_ID = new Identifier("spoky", "morse2");
    public static final SoundEvent MORSE2_EVENT = SoundEvent.of(MORSE2_ID);

    public static void registerSounds() {
        // Registering sounds
    }

    @Override
    public void onInitializeClient() {

        // Register all the sounds
        Registry.register(Registries.SOUND_EVENT, RUBIUS_VOICE1_ID, RUBIUS_VOICE1_EVENT);
        Registry.register(Registries.SOUND_EVENT, BANG1_ID, BANG1_EVENT);
        Registry.register(Registries.SOUND_EVENT, AMBIENT1_ID, AMBIENT1_EVENT);
        Registry.register(Registries.SOUND_EVENT, DRY_HANDS_INTO_ID, DRY_HANDS_INTRO_EVENT);
        Registry.register(Registries.SOUND_EVENT, HEART_ID, HEART_EVENT);
        Registry.register(Registries.SOUND_EVENT, TOCK1_ID, TOCK1_EVENT);
        Registry.register(Registries.SOUND_EVENT, TOCK1_BEHIND_ID, TOCK1_BEHIND_EVENT);
        Registry.register(Registries.SOUND_EVENT, MORSE1_ID, MORSE1_EVENT);
        Registry.register(Registries.SOUND_EVENT, MORSE2_ID, MORSE2_EVENT);
    }
}
