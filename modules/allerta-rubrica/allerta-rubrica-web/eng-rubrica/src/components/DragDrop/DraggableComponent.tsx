import React, { Component, useContext } from "react";
import { useDrag, DndContext } from 'react-dnd';

export function DraggableComponent(props) {
  const dndcontext = useContext(DndContext)
  //console.log(dndcontext)
  if (dndcontext.dragDropManager===undefined) {
    console.log('No context, no DnD')
    return <>{props.children}</>
  }
  const [collectedProps, drag] = useDrag({
    item: { data: props.data, type: props.type },
  })
  //console.log("DraggableComponent")
  //console.log(props)
  return <span ref={drag}>{props.children}</span>
}