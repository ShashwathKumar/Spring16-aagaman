module.exports = function(FlightInfo){
    
    FlightInfo.getStudentsByTime = function(date, time, cb){
        flightinfo.find({where: {departureDate: date,
                                arrivalTime: time}}, function(err, instance){
            var response;
            response = instance;
            cb(null, response);
            console.log(response);
        }); 
    };
    
    FlightInfo.removeAllFlightInfo = function(cb){
        flightinfo.destroyAll(function(err, info){
            var response;
            response = instance;
            cb(null, response);
            console.log(response);
        });
    };
	
	// Testing Airport Pickup
		
	FlightInfo.getMatches = function(details, cb){
		console.log('Client Data: ' +details['flightNum']);
		
		var fltNum = details['flightNum'];
		var fltDate = details['flightDate'];

		FlightInfo.findOne({where: {and: [{flightNum:fltNum}, {flightDate: fltDate}]}, fields:{id:true}},function(err, instance){
			var response;
			response = instance;
			cb(null, response);
			console.log("Flight Server Response: " +response);
		});
		
    };
		
	FlightInfo.remoteMethod(
        'getMatches',
        {
            http: {path: '/getMatches', verb: 'post'},
            accepts: {arg: 'details', type: 'object', http: { source: 'body' }},
            returns: {type: 'object', root: true}
        }
    );
	
	
	// getFlightDateByFlightID Starts
	
	FlightInfo.getFlightDateByFlightID = function(flight_id, cb){		
		FlightInfo.findOne({where: {and: [{id:flight_id}]}, fields:{flight_date:true}},function(err, instance){
			var response;
			response = instance;
			cb(null, response);
			console.log("Flight Server Response: " +response);
		});		
    };
	
	FlightInfo.remoteMethod(
        'getFlightDateByFlightID',
        {
            http: {path: '/getFlightDateByFlightID', verb: 'get'},
            accepts: {arg: 'flight_id', type: 'string'},
            returns: {type: 'object', root: true}
        }
    );
	
	// getFlightDateByFlightID Ends
	
	// Airport Pickup Ends

	FlightInfo.getFlightIDByStudentID = function(stud_id, cb){
		console.log('Student ID' +stud_id);
		
		FlightInfo.findOne({where: {and: [{student_id:stud_id}]}, fields:{id:true}},function(err, instance){
			var response;
			response = instance;
			cb(null, response);
			console.log("Flight ID response " +response);
		});
		
    };
	
	FlightInfo.remoteMethod(
        'getFlightIDByStudentID',
        {
            http: {path: '/getFlightIDByStudentID', verb: 'get'},
            accepts: {arg: 'stud_id', type: 'string'},
            returns: {type: 'object', root: true}
        }
    );
	
    FlightInfo.remoteMethod(
        'getStudentsByTime',
        {
            http: {path: '/getStudentsByTime', verb: 'get'},
            accepts: {arg: 'departureDate', type: 'string'},
            returns: {type: 'array', root: true}
        }
    );
    
    FlightInfo.remoteMethod(
        'removeAllFlightInfo',
        {
            http: {path: '/removeAllFlightInfo', verb: 'get'},
            returns: {arg: 'result', type: 'string'}
        }
    );
};