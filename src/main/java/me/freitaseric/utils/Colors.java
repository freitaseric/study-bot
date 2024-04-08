package me.freitaseric.utils;

public enum Colors {
    GREEN(0x00fa9a), RED(0xdc143c), BLUE(0x4169e1), CYAN(0x00ffff), AQUAMARINE(0x7fffd4), PURPLE(0x7b68ee), MAGENTA(0xff00ff), PINK(0xff69b4), GOLD(0xffd700), YELLOW(0xfffacd), LAVENDER(0xe6e6fa), WHITE(0xf8f8ff), HONEYDEW(0xf0fff0);

    private final int hex;

    Colors(int hex) {
        this.hex = hex;
    }

    public int getHex() {
        return hex;
    }
}
