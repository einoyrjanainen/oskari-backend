package org.geotools.mif;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.geotools.data.Query;
import org.geotools.data.store.ContentDataStore;
import org.geotools.data.store.ContentEntry;
import org.geotools.data.store.ContentFeatureSource;
import org.geotools.feature.NameImpl;
import org.opengis.feature.type.Name;

public class MIFDataStore extends ContentDataStore {

    private final File mif;
    private final File mid;

    public MIFDataStore(File mif, File mid) {
        this.mif = mif;
        this.mid = mid;
    }

    @Override
    protected List<Name> createTypeNames() throws IOException {
        String name = mif.getName();
        name = name.substring(0, name.lastIndexOf('.'));
        Name typeName = new NameImpl(name);
        return Collections.singletonList(typeName);
    }

    @Override
    protected ContentFeatureSource createFeatureSource(ContentEntry entry) throws IOException {
        return new MIFFeatureSource(entry, Query.ALL);
    }

    MIFHeader readHeader() throws IOException {
        return new MIFHeader(mif);
    }

    MIFDataReader openData() throws IOException {
        return new MIFDataReader(mif);
    }

    MIDReader openMID(MIFHeader header) throws IOException {
        MIDReader reader;
        if (mid.exists()) {
            reader = new MIDReader();
            reader.init(mid, header);
        } else {
            reader = new NoMIDReader();
        }
        return reader;
    }

}
