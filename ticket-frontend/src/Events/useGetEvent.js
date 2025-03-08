import { useEffect, useState } from "react"



export const useGetEvent = () => {
  
    const [events, setEvents] = useState(undefined);

    useEffect( () => {
        loadEvents();
    },[])


    const loadEvents = async () => {
        try{
            let response = await fetch("https://goldfish-app-fbulw.ondigitalocean.app/event?applicationId=e22a86d1-e977-45d2-9410-11a4ec7faa17", {
                method:"GET",
            })

            let data = await response.json();
            setEvents(data);
        }
        catch(error){
            console.log(error);
        }
    }

    return events;


}
