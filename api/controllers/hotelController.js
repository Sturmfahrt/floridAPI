var mongoose = require('mongoose');
var hotel = require('../models/hotel');

exports.add_hotel_room = function(req, res) {
    var new_room = new hotel(req.body);
    new_room.save(function(err, room) {
        if(err)
            res.send(err);
        res.json(room);
    });
};

exports.list_hotel_room = function(req,res) {
    hotel.find({ $and: [{hotelName: req.query.hotelName}, {roomNumber: req.query.roomNumber}]}, function(err, room) {
        if(err)
            res.send(err);
        res.json(room);
    });
};

exports.update_hotel_room = function(req,res) {
    var docId = req.params.id;
    hotel.findById(docId, function(err, Hotel) {
        if (err) return handleError(err);
        
        Hotel.set(req.query);
        Hotel.save(function(err, updatedHotel) {
            if (err) return handleError(err);
            res.send(updatedHotel);
        });
    });
};

exports.delete_hotel_room = function(req, res) {
    hotel.findById(req.params.id, function(err, Hotel) {

        if(err) return handleRror(err);

        Hotel.field = undefined;
        Hotel.save(callback);
            res.send(err);
        res.json(Hotel);
    });
};

//put delete hotel room code here.