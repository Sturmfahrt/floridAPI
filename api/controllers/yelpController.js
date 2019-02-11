var term;
var loca;
var cost;
const apiKey = 'o-Jyuwf5wA67Pnsnz6SbYsXaq5C7hPP1IODAJxoLrMVseBzSNbv1ANN9B5Jz1OKltC3xJA5G6tJotSOwrLfK4otUXMr26DGCRsQz7f-YspBvUu-j_NsWTCkJQ4TsW3Yx';
var rp = require('request-promise');

exports.get_info = function(req, res) {
    term = req.query.term;
    loca = req.query.location;
    cost = req.query.price;

    var options = {
    method: 'GET',
    uri: 'https://api.yelp.com/v3/businesses/search',
    qs: {
        term: term,
        location: loca,
        price: cost
    },
    headers: {
        'User-Agent': 'Request-Promise',
        'authorization': 'bearer '+ apiKey
    },
    json: true // Automatically parses the JSON string in the response
    };
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
} 
