var mongoose = require('mongoose');

var hotelSchema = mongoose.Schema({
    hotelName: {
        type: String,
        required: 'Enter hotel name'
    },
    roomNumber: {
        type: Number,
        required: 'room number required'
    },
    roomType: {
        type: String,
        required: 'room type required'
    },
    floorNumber: {
        type: Number
    },
    description: {
        type: String,
        required: 'description required'
    },
    price: {
        type: Number,
        required: 'prices per night required'
    },
    address: {
        type: String,
        required: 'please enter hotel address'
    },
    images: {
        type: [String],
        required: 'please enter url for images.'
    },
    booker: {
        name: {
            type: String,
            required: 'name of the guest is needed'
        },
        nightCount: {
            type: String,
            required: 'number of nights guest is staying needed.'
        },
        notes: {
            type: String
        },
        checkedIn: {
            type: Boolean,
            required: 'is the guest currently checked in.'
        }
    }
});

var hotel = mongoose.model('hotels', hotelSchema);

module.exports = hotel;