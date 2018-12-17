var mongoose = require('mongoose');


var metroAreaSchema = mongoose.Schema({
    name: {
        type: String,
        required: 'Enter a Metro Area name'
    }
});

var metroArea = mongoose.model('metroArea', metroAreaSchema);

module.exports = metroArea;