var mongoose = require('mongoose');
var metroArea = require('../models/metroArea');
var city = require('../models/city');
var thingsTodo = require('../models/thingsTodo');

exports.list_things_todo = function(req, res) {
    thingsTodo.find({ cityname: req.query.cityName}, function(err, thingTodo) {
        if (err)
            res.send(err);
        res.json(thingTodo);
    });
};

exports.add_metro_area = function(req, res) {
    var new_metro = new metroArea(req.body);
    new_metro.save(function(err, metro) {
        if (err)
            res.send(err);
        res.json(metro);
    });
};
exports.add_city = function(req, res) {
    var new_city = new city(req.body);
    new_city.save(function(err, cityTemp) {
        if (err)
            res.send(err);
        res.json(cityTemp);
    })
}

exports.add_things_todo = function(req, res) {
    var new_thing = new thingsTodo(req.body);
    new_thing.save(function(err, thingTodo) {
        if (err)
            res.send(err);
        res.json(thingTodo);
    });
};