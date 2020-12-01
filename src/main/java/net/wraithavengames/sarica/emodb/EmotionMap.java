package net.wraithavengames.sarica.emodb;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A representation of a set of emotions and their corresponding value as held
 * by an object.
 */
public class EmotionMap {
    private final Map<String, Float> values = new HashMap<>();

    /**
     * Sets the value for a given emotion. If the value is assigned to 0, it is
     * removed from the map.
     * 
     * @param emotion - The name of the emotion.
     * @param value   - The current value of that emotion.
     */
    public void setValue(String emotion, float value) {
        if (value == 0) {
            values.remove(emotion);
            return;
        }

        values.put(emotion, value);
    }

    /**
     * Gets the value of the emotion. All emotions that are not in this map are
     * assumed to have a value of 0.
     * 
     * @param emotion - The name of the emotion.
     * @return The emotion value.
     */
    public float getValue(String emotion) {
        if (values.containsKey(emotion))
            return values.get(emotion);
        else
            return 0f;
    }

    /**
     * Gets a set of all emotion names that currently have a non-zero value in this
     * map.
     * 
     * @return A set of emotions.
     */
    public Set<String> getEffectedEmotions() {
        return values.keySet();
    }
}
