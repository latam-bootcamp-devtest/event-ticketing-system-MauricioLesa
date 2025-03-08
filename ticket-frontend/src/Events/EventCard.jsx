import React from 'react'

function EventCard({props}) {


    
  return (
    <div key={props.id} className='w-fit rounded-4xl p-6 bg-amber-400'>
        <img src={props.image} className='h-[400px] w-[600px]'>

        </img>
        <div>
            <p className='mt-3'>name:  {props.name}</p>
            <p className='mt-3'>date:  {props.data}</p>
            <p className='mt-3'>ticket price:  {props.price}</p>
        </div>
    </div>
  )
}

export default EventCard