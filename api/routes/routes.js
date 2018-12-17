module.exports = function(app) {
  var yelp = require('../controllers/yelpController');
  var weather = require('../controllers/weatherController');
  var thingsToDo = require("../controllers/thingsToDoController");


  app.route('/yelp')
    .get(yelp.get_info);
  
  app.route('/weather')
    .get(weather.read_weather);

  app.route('/thingstodo')
    .get(thingsToDo.list_things_todo);

  app.route('/thingstodo/addmetro')
    .post(thingsToDo.add_metro_area);

  app.route('/thingstodo/addcity')
    .post(thingsToDo.add_city);
  
  app.route('/thingstodo/addthingstodo')
    .post(thingsToDo.add_things_todo);
};
