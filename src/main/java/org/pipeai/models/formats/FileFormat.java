package org.pipeai.models.formats;

public enum FileFormat {
    PNG("png"),
    JPG("jpg"),
    JPEG("jpeg"),
    PDF("pdf");

    private final String extension;

    FileFormat(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return extension;
    }

}
