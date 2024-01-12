
// dot styles
const inputText = "inputText";
const inputTextStyle =  [0, 0.25, 8, 8];

const inputFile = "inputFile";
const inputFileStyle =  [0, 0.75, 8, 8];

const outputText = "outputText";
const outputTextStyle =  [1, 0.25, 8, 8];

const outputFile = "outputFile";
const outputFileStyle =  [1, 0.75, 8, 8];


var portStyleText = 'shape=ellipse;' +
    'perimeter=ellipsePerimeter;' +
    'fillColor=#FFFFFF;' +
    'strokeColor=rgba(153,0,0,1);' +
    'strokeWidth=1;' +
    'fontColor=rgba(0,255,0,0);' +
    'fontSize=12;' +
    'fontFamily=Arial;' +
    'align=center;' +
    'verticalAlign=middle;' +
    'spacingTop=2;' +
    'spacingRight=4;';

var portStyleFile = 'shape=ellipse;' +
    'perimeter=ellipsePerimeter;' +
    'fillColor=#FFFFFF;' +
    'strokeColor=rgba(0,102,51,1);' +
    'strokeWidth=1;' +
    'fontColor=rgba(255,255,0,0);' +
    'fontSize=12;' +
    'fontFamily=Arial;' +
    'align=center;' +
    'verticalAlign=middle;' +
    'spacingTop=2;' +
    'spacingRight=4;';

class ModelComponent{
    constructor(modelID,cell,dots,name,ModelContextJson,DataStreamContext) {
        this.modelID=modelID; // like CharGPTv35

        this.cell = cell; // main cell
        this.dots = dots // an array of all dots(input ans output) belong to the main cell
        this.ModelName = name;

        this.connectFrom = []; // other-nodes -> this-node (UUID)
        this.connectFromStyle = []; // text or file

        this.connectTo = []; // this-nodes -> other-nodes (UUID)
        this.connectToStyle = []; // text or file

        // full json for this model, just from backend obj, for now user should edit this json directly
        // next step should let use able to edit it from ui
        // (one good thing is that frontend no need to understand this json, just need to provide a UI)
        this.ModelContextJson = ModelContextJson;

        // DataStreamContext.java's obj from backend
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

class cellGeo{
    x=0;
    y=0;
    height=0;
    width=0;
}

class SimpleModelComponent{
    cellGeo;
    constructor(modelComponent) {
        this.modelID = modelComponent.modelID;

        // this.cellGeo = modelComponent.cell.geometry;
        this.cellGeo = new cellGeo();
        this.cellGeo.x = parseFloat(modelComponent.cell.geometry.x);
        this.cellGeo.y = parseFloat(modelComponent.cell.geometry.y);
        this.cellGeo.height = parseFloat(modelComponent.cell.geometry.height);
        this.cellGeo.width = parseFloat(modelComponent.cell.geometry.width);

        this.ModelName = modelComponent.ModelName;

        this.connectFrom = modelComponent.connectFrom; // other-nodes -> this-node (UUID)
        this.connectFromStyle = modelComponent.connectFromStyle; // text or file

        this.connectTo = modelComponent.connectTo; // this-nodes -> other-nodes (UUID)
        this.connectToStyle = modelComponent.connectToStyle; // text or file

        this.ModelContextJson = modelComponent.ModelContextJson;

        this.DataStreamContext = modelComponent.DataStreamContext;

        this.uuid = modelComponent.uuid;
    }
}