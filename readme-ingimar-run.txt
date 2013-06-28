Kan köra -> http://localhost:8080/Playerserver/webresources/com.playerentity.player
borde ändra @Path från com.playerentity.player till endast player - Lyckas inte ...

http://localhost:8080/Playerserver/webresources/com.playerentity.player/count

Hämtar ...
Runs the following :
 @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Player> findAll() {
        return super.findAll();
    }

Kan även köra : Snyggt: Antingen xml eller json ....
 curl -H "Accept:application/xml" http://localhost:8080/Playerserver/webresources/com.playerentity.player
 curl -H "Accept:application/json" http://localhost:8080/Playerserver/webresources/com.playerentity.player
