var mongoose = require('mongoose');


var thingsToDoSchema = new mongoose.Schema({
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
            type: Number,
            default: 0.00
        }
    }]
});

var ThingsTodo = mongoose.model('ThingsTodo', thingsToDoSchema);

module.exports = ThingsTodo;