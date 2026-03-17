package me.akranium.util;

import me.akranium.data.Dialogue;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Methods {
    public static List<Dialogue> deepCopy(@Nullable List<Dialogue> source) {
        if(source == null) {
            return null;
        }
        List<Dialogue> copy = new ArrayList<>();
        for (Dialogue d : source) {
            copy.add(new Dialogue(d));
        }
        return copy;
    }
}
