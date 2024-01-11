
// dot styles
const inputText = "inputText";
const inputFile = "inputFile";
const outputText = "outputText";
const outputFile = "outputFile";

class ModelComponent{
    constructor(modelID,cell,dots,name,ModelContextJson,DataStreamContext) {
        this.modelID=modelID;

        this.cell = cell; // main cell
        this.dots = dots // an array of all dots belong to the main cell
        this.ModelName = name;

        this.connectFrom = []; // other-nodes -> this-node (UUID)
        this.connectFromStyle = []; // text or file

        this.connectTo = []; // this-nodes -> other-nodes (UUID)
        this.connectToStyle = []; // text or file

        // full json for this model, just from backend obj, for now user should edit this json directly
        // next step should let use able to edit it from ui
        this.ModelContextJson = ModelContextJson;

        this.DataStreamContext = DataStreamContext;

        this.uuid = generateUUID();
    }
}


function generateUUID() {
    let dt = new Date().getTime();
    const uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        const r = (dt + Math.random() * 16) % 16 | 0;
        dt = Math.floor(dt / 16);
        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
    return uuid;
}

class SimpleModelComponent{
    constructor(modelComponent) {
        this.modelID = modelComponent.modelID;

        this.cellGeo = modelComponent.cell.geometry;

        this.ModelName = modelComponent.name;

        this.connectFrom = modelComponent.connectFrom; // other-nodes -> this-node (UUID)
        this.connectFromStyle = modelComponent.connectFromStyle; // text or file

        this.connectTo = modelComponent.connectTo; // this-nodes -> other-nodes (UUID)
        this.connectToStyle = modelComponent.connectToStyle; // text or file

        // full json for this model, just from backend obj, for now user should edit this json directly
        // next step should let use able to edit it from ui
        this.ModelContextJson = modelComponent.ModelContextJson;

        this.DataStreamContext = modelComponent.DataStreamContext;

        this.uuid = modelComponent.uuid;
    }
}

// class ModelComponent{
//     constructor(cell,dots,parameters) {
//         this.cell = cell; // main cell
//         this.dots = dots // an array of all dots belong to the main cell
//
//         // parameters for model
//         this.parameters = parameters
//
//         this.inputText = [];
//         this.inputFiles = [];
//         this.outputText = [];
//         this.outputFiles = [];
//
//         // [
//         //  [texts,files],
//         //  [texts,files],
//         // ]
//         this.context = [];
//
//         // model running status
//         this.status = "init";
//     }
// }
//
//
//
// class ModelParameter {
//     constructor(parameterType,initVal,explanation) {
//         this.parameterType = parameterType; // int, float, text
//         this.initVal = initVal;
//         this.explanation = explanation; // explanation for this parameter
//     }
// }