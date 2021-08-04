package org.bookmc.srg.output;

public class MappedClass {
    private final String obfuscatedName;
    private final String deobfuscatedName;

    public MappedClass(String obfuscatedName, String deobfuscatedName) {
        this.obfuscatedName = obfuscatedName;
        this.deobfuscatedName = deobfuscatedName;
    }

    public String getObfuscatedName() {
        return obfuscatedName;
    }

    public String getDeobfuscatedName() {
        return deobfuscatedName;
    }

    @Override
    public String toString() {
        return obfuscatedName + "=" + deobfuscatedName;
    }
}
