var mongoose = require('mongoose');
var Schema = mongoose.Schema;


var thingsToDoSchema = new Schema({
    cityname: {
        type: String,
        required: 'Enter a cityName'
    },
    metroarea: String,
    thingsToDo: [{
        name: {
            type: String,
            default: 'name for thing to do required'
        },
        description: {
            type: String,
            default: 'No Description was entered.'
        },
        time: {
            type: Date,
            default: Date.now
        },
        location: {
            type: String,
            default: 'no location was entered'
        },
        price: {
            type: number,
            default: 0.00
        }
    }]
});

module.exports = mongoose.model('ThingsTodo', thingsToDoSchema);