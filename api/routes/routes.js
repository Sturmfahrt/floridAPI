module.exports = function(app) {
  var yelp = require('../controllers/yelpController');
  var weather = require('../controllers/weatherController');
  var thingsToDo = require("../controllers/thingsToDoController");
  var hotels = require('../controllers/hotelController');


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

  app.route('/hotels/listhotelroom')
    .get(hotels.list_hotel_room);

  app.route('/hotels/addhotel')
    .post(hotels.add_hotel_room);
  
  app.route('/hotels/:id/updateroom')
    .post(hotels.update_hotel_room);

  app.route('/hotels/:id/deleteroom')
    .delete(hotels.delete_hotel_room);
};
