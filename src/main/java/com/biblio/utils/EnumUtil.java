package com.biblio.utils;

import java.lang.reflect.Field;

public class EnumUtil {
    public static <T extends Enum<T>> String toDisplayName(T enumConstant) {
        try {
            Field displayNameField = enumConstant.getClass().getDeclaredField("displayName");
            displayNameField.setAccessible(true);
            return (String) displayNameField.get(enumConstant);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException("Enum " + enumConstant.getClass().getName() + " does not have a displayName field", e);
        }
    }

    public static <T extends Enum<T>> T fromDisplayName(Class<T> enumClass, String displayName) {
        try {
            Field displayNameField = enumClass.getDeclaredField("displayName");
            displayNameField.setAccessible(true);

            for (T enumConstant : enumClass.getEnumConstants()) {
                String value = (String) displayNameField.get(enumConstant);
                if (value.equalsIgnoreCase(displayName)) {
                    return enumConstant;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException("Enum " + enumClass.getName() + " does not have a displayName field", e);
        }

        throw new IllegalArgumentException("No enum constant with displayName " + displayName);
    }
}
