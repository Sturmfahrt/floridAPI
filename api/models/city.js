var mongoose = require('mongoose');


var citySchema = mongoose.Schema({
    name: {
        type: String,
        required: 'Enter a cityName'
    },
    description: String,
    metroarea: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'metroArea'
    }
});

var city = mongoose.model('city', citySchema);

module.exports = city;