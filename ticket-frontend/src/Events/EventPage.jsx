import React from 'react'
import EventCard from './EventCard'
import { useGetEvent } from './useGetEvent'

function EventPage() {

    const data = useGetEvent();

    if(data == undefined) return ( <div>error</div>)
    if(data.lenght == 0) return (<div>no hay eventos</div>)
    return (
    <div>
        <h1>Upcoming Events</h1>
        <div className='flex justify-evenly h-fit flex-wrap row gap-[100px]'>
            {data?.map(event => (
                <EventCard props={event}/>
            ))}
        </div>
    </div>
  )
}

export default EventPage