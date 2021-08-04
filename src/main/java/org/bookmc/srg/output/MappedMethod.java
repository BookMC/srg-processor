package org.bookmc.srg.output;

public class MappedMethod {
    private final String obfuscatedOwner;
    private final String deobfuscatedOwner;

    private final String obfuscatedName;
    private final String deobfuscatedName;

    private final String obfuscatedDescriptor;
    private final String deobfuscatedDescriptor;

    public MappedMethod(String obfuscatedOwner, String deobfuscatedOwner, String obfuscatedName, String deobfuscatedName, String obfuscatedDescriptor, String deobfuscatedDescriptor) {
        this.obfuscatedOwner = obfuscatedOwner;
        this.deobfuscatedOwner = deobfuscatedOwner;
        this.obfuscatedName = obfuscatedName;
        this.deobfuscatedName = deobfuscatedName;
        this.obfuscatedDescriptor = obfuscatedDescriptor;
        this.deobfuscatedDescriptor = deobfuscatedDescriptor;
    }

    public String getObfuscatedOwner() {
        return obfuscatedOwner;
    }

    public String getDeobfuscatedOwner() {
        return deobfuscatedOwner;
    }

    public String getObfuscatedName() {
        return obfuscatedName;
    }

    public String getDeobfuscatedName() {
        return deobfuscatedName;
    }

    public String getObfuscatedDescriptor() {
        return obfuscatedDescriptor;
    }

    public String getDeobfuscatedDescriptor() {
        return deobfuscatedDescriptor;
    }

    @Override
    public String toString() {
        return obfuscatedOwner + "/" + obfuscatedName + obfuscatedDescriptor + "=" + deobfuscatedOwner + "/" + deobfuscatedName + obfuscatedDescriptor;
    }
}
