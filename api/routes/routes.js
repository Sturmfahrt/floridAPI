module.exports = function(app) {
  var todoList = require('../controllers/todoListController');
  var yelp = require('../controllers/yelpController');
  var weather = require('../controllers/weatherController');
  var thingsToDo = require("../controllers/thingsToDoController");


  // todoList Routes
  app.route('/tasks')
    .get(todoList.list_all_tasks)
    .post(todoList.create_a_task);

  app.route('/tasks/:taskId')
    .get(todoList.read_a_task)
    .put(todoList.update_a_task)
    .delete(todoList.delete_a_task);

  app.route('/yelp')
    .get(yelp.get_info);
  
  app.route('/weather')
    .get(weather.read_weather);

  app.route('/thingstodo')
    .get(thingsToDo.list_things_todo)
    .post(thingsToDo.add_things_todo);
};
