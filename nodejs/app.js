const express = require('express');

const app = express();

app.get('/', (req, res) => {
  res.status(200).send('Hello, world!').end();
});

app.post('/process', function(req, res) {
//    var o2 = req.body.o2;
//	    var co2= req.body.co2;
//	    var voc= req.body.voc;
//	    var temperature= req.body.temperature;
//	    var humidity= req.body.humidity;
//	    var latitude= req.body.latitude;
//	    var longitude= req.body.longitude;
//	    var elevation= req.body.elevation;
//	    var deviceID= req.body.deviceID;
	//  console.log("User name = " + user_name + ", password is " + password);
  res.end(req.body);
});

// Start the server
const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
  console.log(`App listening on port ${PORT}`);
  console.log('Press Ctrl+C to quit.');
});
