import React, { Component, useContext } from "react";
import { useDrop, DndContext } from 'react-dnd';

export function DroppableComponent(props) {
  const dndcontext = useContext(DndContext)
  //console.log(dndcontext)
  if (dndcontext.dragDropManager===undefined) {
    console.log('No context, no DnD')
    return <>{props.children}</>
  }
  const [collectedProps, drop] = useDrop({
    accept: props.accept,
    drop: props.drop
  })
  //console.log("DroppableComponent")
  //console.log(props)
  return <div ref={drop}>{props.children}</div>
}