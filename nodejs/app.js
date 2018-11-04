const express = require('express');
const app = express();
app.use(express.json());

const config = {
  user: 'root',
  password: 'password',
  database: 'petclinic'
};

config.socketPath: '/cloudsql/$optimum-parity-221406:us-central1:instance-1';

// Connect to the database
const knex = Knex({
  client: 'mysql',
  connection: config
});

app.get('/', (req, res) => {
  res.status(200).send('Hello, world!').end();
});

app.post('/process', function(req, res) {

    var o2 = req.body.o2;
    var co2 = req.body.co2;
    var voc = req.body.voc;
    var temperature = req.body.temperature;
    var humidity = req.body.humidity;
    var latitude = req.body.latitude;
    var longitude = req.body.longitude;
    var elevation = req.body.elevation;
    var deviceID = req.body.deviceID;

    knex('entries').insert(o2, co2, voc, temperature, humidity, latitude, longitude, elevation);

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
