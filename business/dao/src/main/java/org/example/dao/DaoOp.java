package org.example.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//Этот касс отвечает за операции сериализации/десериализации
//Возможно, я позже перенесу сюда CRUD операции
public class DaoOp<T> {

    protected final String filePath;
    protected final Class<T> clazz;

    public DaoOp(String filePath, Class<T> clazz) {
        this.filePath = filePath;
        this.clazz = clazz;
    }

    public void write(List<T> data) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(data);
        }
    }

    public List<T> read() throws IOException, ClassNotFoundException {
        List<T> data = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return data;
        }
        try (InputStream inputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            data = (List<T>) objectInputStream.readObject();
        }
        return data;
    }

}
