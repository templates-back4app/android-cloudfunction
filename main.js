Parse.Cloud.define("welcomeToBack4App", (request) => {
  let name = request.params.name;

  let object = `Welcome ${name}!`;

  return object;
});
