const express = require('express');
const app = express();
const Knex = require('knex');

app.use(express.json());

const config = {
  user: 'root',
  password: 'password',
  database: 'petclinic',
  socketPath: '/cloudsql/$optimum-parity-221407:us-central1:instance-1'
	}


// Connect to the database
const knex = Knex({
  client: 'mysql',
  connection: config
});

app.get('/', (req, res) => {
  res.status(200).send('Hello, world!').end();
});

app.post('/process', function(req, res) {

	console.log('start');

    var o2_var = req.body.o2;
    var co2_var = req.body.co2;
    var voc_var = req.body.voc;
    var temperature_var = req.body.temperature;
    var humidity_var = req.body.humidity;
    var latitude_var = req.body.latitude;
    var longitude_var = req.body.longitude;
    var elevation_var = req.body.elevation;
    var deviceID_var = req.body.deviceID;

    knex('entries').insert(
        {o2: o2_var},
        {co2: co2_var},
        {voc: voc_var},
        {temperature: temperature_var},
        {humidity: humidity_var},
        {latitude: latitude_var},
        {longitude: longitude_var },
        {elevation: elevation_var }
    )


	console.log('done');
    res.status(200).send();

});

// Start the server
const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
  console.log(`App listening on port ${PORT}`);
  console.log('Press Ctrl+C to quit.');
});

// CREATE TABLE IF NOT EXISTS entries (
//      o2 DECIMAL,
//      co2 DECIMAL,
//      voc DECIMAL,
//      temperature DECIMAL,
//      humidity DECIMAL,
//      latitude DECIMAL,
//      longitude DECIMAL,
//      elevation DECIMAL,
//      time TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
// );
//
// insert into entries (o2, co2, voc, temperature, humidity, latitude, longitude, elevation)
// values (1,1,1,1,1,1,1,1);
//
// INSERT INTO Customer (FirstName, LastName)
// VALUES ('Anita', 'Coats')
