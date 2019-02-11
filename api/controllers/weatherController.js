var rp = require('request-promise');

exports.read_weather = function(req, res) {
    var time = req.query.time;
    var inputName = req.query.cityName;
    var options;
    if(time == "current"){
        options = {
            method: 'GET',
            uri: 'http://api.openweathermap.org/data/2.5/weather',
            qs: {
                q: inputName,
                APPID: '8ed55356b0c310798b7216c27917e611'
            },
            headers: {
                'User-Agent': 'Request-Promise'
            },
            json: true // Automatically parses the JSON string in the response
        };
    }else if(time == "forecast"){
        options = {
            method: 'GET',
            uri: 'http://api.openweathermap.org/data/2.5/forecast',
            qs: {
                q: inputName,
                APPID: '8ed55356b0c310798b7216c27917e611'
            },
            headers: {
                'User-Agent': 'Request-Promise'
            },
            json: true // Automatically parses the JSON string in the response
        };
    }else{
        res.send("please specify whether you need current or forecast");
    }
    rp(options)
        .then(function (body) {
        console.log('data retreived');
        console.log(body);
        res.send(body);
        })
        .catch(function (err) {
        console.log('error has occured');
        console.log(err);
        res.send(err);
        });
};