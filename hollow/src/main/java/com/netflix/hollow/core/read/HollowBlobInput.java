package com.netflix.hollow.core.read;

import com.netflix.hollow.core.memory.encoding.BlobByteBuffer;
import com.netflix.hollow.core.memory.encoding.VarInt;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class HollowBlobInput {
    Object o;
    BlobByteBuffer buffer;

    private HollowBlobInput() {}

    public static HollowBlobInput randomAccessFile(File f) throws IOException {
        HollowBlobInput hbi = new HollowBlobInput();
        RandomAccessFile raf = new RandomAccessFile(f, "r");
        hbi.o = raf;
        FileChannel channel = ((RandomAccessFile) hbi.o).getChannel();
        hbi.buffer = BlobByteBuffer.mmapBlob(channel);
        return hbi;
    }

    public static HollowBlobInput inputStream(InputStream is) {
        HollowBlobInput hbi = new HollowBlobInput();
        DataInputStream dis = new DataInputStream(is);
        hbi.o = dis;
        return hbi;
    }

    public BlobByteBuffer getBuffer() { // SNAP: TODO: Should I put a type check here? performance concerns?
        return buffer;
    }

    /**
     * Reads the next byte of data from the input stream by relaying the call to the underlying {@code DataInputStream} or
     * {@code RandomAccessFile}. The byte is returned as an integer in the range 0 to 255.
     *
     * @return an integer in the range 0 to 255
     * @throws IOException if underlying {@code DataInputStream} or {@code RandomAccessFile}
     * @throws UnsupportedOperationException if the input type wasn't  one of {@code DataInputStream} or {@code RandomAccessFile}
     */
    public int read() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).read();
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).read();
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public int read(byte b[], int off, int len) throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).read(b, off, len);
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).read(b, off, len);
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    /**
     * Sets the file-pointer to the desired offset measured from the beginning of the file by relaying the call to the
     * underlying {@code RandomAccessFile}. Operation not supported if the Hollow Blob Input is an {@code DataInputStream}.
     *
     * @param pos the position in bytes from the beginning of the file at which to set the file pointer to.
     * @exception IOException if originated in the underlying {@code RandomAccessFile} implementation
     * @exception UnsupportedOperationException if called when Hollow Blob Input is not a {@code RandomAccessFile}
     */
    public void seek(long pos) throws IOException {
        if (o instanceof RandomAccessFile) {
            ((RandomAccessFile) o).seek(pos);
        } else if (o instanceof DataInputStream) {
            throw new UnsupportedOperationException("Can not seek on Hollow Blob Input of type DataInputStream");
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public long getFilePointer() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).getFilePointer();
        } else if (o instanceof DataInputStream) {
            throw new UnsupportedOperationException("Can not deserializeFrom file pointer for Hollow Blob Input of type DataInputStream");
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public final short readShort() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).readShort();
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).readShort();
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public final int readInt() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).readInt();
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).readInt();
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public final long readLong() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).readLong();
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).readLong();
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public final String readUTF() throws IOException {
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).readUTF();
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).readUTF();
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }

    public int skipBytes(long n) throws IOException {
        // SNAP: TODO: lossy long to int cast here. InputStream used to have a skip(long) method
        if (o instanceof RandomAccessFile) {
            return ((RandomAccessFile) o).skipBytes((int) n);
        } else if (o instanceof DataInputStream) {
            return ((DataInputStream) o).skipBytes((int) n);
        } else {
            throw new UnsupportedOperationException("Unknown Hollow Blob Input type");
        }
    }
}
