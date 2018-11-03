package com.netflix.vms.transformer.hollowoutput;

import com.netflix.hollow.core.write.objectmapper.HollowPrimaryKey;
import java.util.Arrays;

@HollowPrimaryKey(fields="nameStr")
public class ArtWorkImageFormatEntry implements Cloneable {

    public char[] nameStr = null;
    public int width = java.lang.Integer.MIN_VALUE;
    public int height = java.lang.Integer.MIN_VALUE;

    public boolean equals(Object other) {
        if(other == this)  return true;
        if(!(other instanceof ArtWorkImageFormatEntry))
            return false;

        ArtWorkImageFormatEntry o = (ArtWorkImageFormatEntry) other;
        if(!Arrays.equals(o.nameStr, nameStr)) return false;
        if(o.width != width) return false;
        if(o.height != height) return false;
        return true;
    }

    public int hashCode() {
        int hashCode = 1;
        hashCode = hashCode * 31 + Arrays.hashCode(nameStr);
        hashCode = hashCode * 31 + width;
        hashCode = hashCode * 31 + height;
        return hashCode;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("ArtWorkImageFormatEntry{");
        builder.append("nameStr=").append(nameStr);
        builder.append(",width=").append(width);
        builder.append(",height=").append(height);
        builder.append("}");
        return builder.toString();
    }

    public ArtWorkImageFormatEntry clone() {
        try {
            ArtWorkImageFormatEntry clone = (ArtWorkImageFormatEntry)super.clone();
            clone.__assigned_ordinal = -1;
            return clone;
        } catch (CloneNotSupportedException cnse) { throw new RuntimeException(cnse); }
    }

    @SuppressWarnings("unused")
    private long __assigned_ordinal = -1;
}