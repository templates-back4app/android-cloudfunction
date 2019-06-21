Parse.Cloud.define("welcomeToBack4App", (request) => {
  let name = request.params.name;

  let object = `Welcome ${name}!`;

  return object;
});

Parse.Cloud.define("sendPushFromArrayToFunction", async (request) => {
  	let platforms = request.params.devices;

  	console.log(JSON.parse(platforms))

  	let query = new Parse.Query(Parse.Installation);
  	query.containedIn("deviceType", JSON.parse(platforms));

  	return Parse.Push.send({
	  where: query, // Set our Installation query
	  data: {
	    alert: "Push sent by CC."
	  }
	}, {useMasterKey: true})
	.then(function() {
	  	return "Push was sent successfully!"
	}, function(error) {
	  // Handle error
	  return JSON.stringify(error);
	});
});