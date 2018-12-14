var mongoose = require('mongoose'),
    thingsTodo = mongoose.model('ThingsTodo');

exports.list_things_todo = function(req, res) {
    thingsTodo.find({ cityname: req.query.cityName}, function(err, thingTodo) {
        if (err)
          res.send(err);
        res.json(thingTodo);
    });
};

exports.add_things_todo = function(req, res) {
    var new_thing = new thingsTodo(req.body);
    new_thing.save(function(err, thingTodo) {
        if (err)
          res.send(err);
        res.json(thingTodo);
    });
};