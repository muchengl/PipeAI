package org.pipeai.models.formats;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataStreamContext {
    // data
    List<String> inputText;
    List<String> inputFile;  // local address for file. for some platforms like chatgpt, need to upload it to remote env and provide a url.
    List<String> outputText;
    List<String> outputFile; // local address for file, platform will download all file to local.

    // formats
    long inputTextMaxNum;
    long inputTextMaxLength;

    long inputFileMaxNum;
    long inputFileMaxSize;

    // NOT_ACCEPTED | OPTIONAL | MANDATORY
    ModelDataAcceptance inputTextEnable;
    ModelDataAcceptance inputFileEnable;
    ModelDataAcceptance outputTextEnable;
    ModelDataAcceptance outputFileEnable;

    FileFormat inputFileFormat;
    FileFormat outputFileFormat;
}
