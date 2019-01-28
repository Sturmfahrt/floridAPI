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
    nightsUnavailable: {
        type: [Number]
    },
    booker: [{
        name: {
            type: String,
        },
        notes: {
            type: String
        },
        nightsBooked: {
            type: [Number],
        },
        checkedIn: {
            type: Boolean,
        }
    }]
});

var hotel = mongoose.model('hotels', hotelSchema);

module.exports = hotel;