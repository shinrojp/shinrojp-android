package com.shinro.shinrojp_android.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.shinro.shinrojp_android.utils.AppLogger;

import java.io.IOException;

import kotlin.jvm.Throws;

public class LenientTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        return new TypeAdapter<T>() {
            @Throws(exceptionClasses = IOException.class)
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Throws(exceptionClasses = IOException.class)
            @Override
            public T read(JsonReader in) throws IOException {
                try {
                    return delegate.read(in);
                } catch (Exception e) {
                    AppLogger.e("*** PARSE JSON ERROR *** - " + in + " in " + type);
                    in.skipValue();
                    return null;
                }
            }
        };
    }

}
