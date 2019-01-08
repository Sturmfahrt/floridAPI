var mongoose = require('mongoose');


var thingsToDoSchema = new mongoose.Schema({
    name: {
        type: String,
        required: 'name for thing to do required'
    },
    description: {
        type: String,
        default: 'No Description was entered.'
    },
    time: {
        type: Date,
        default: Date.now
    },
    cityname: {
        type: String,
        default: 'city name was not entered'
    },
    cityid: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'city'
    },
    location: {
        type: String,
        default: 'no location was entered'
    },
    price: {
        type: Number,
        default: 0.00
    }
});

var thingsTodo = mongoose.model('thingsTodo', thingsToDoSchema);

module.exports = thingsTodo;