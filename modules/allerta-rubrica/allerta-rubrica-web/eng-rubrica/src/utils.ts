export const debounced = (func: (args?:any) => void, wait: number) => {
  let timeout: NodeJS.Timeout;
  return (args: any) => {
    args.persist();
    if (timeout) {
      clearTimeout(timeout);
    }
    timeout = setTimeout(() => {
      func(args);
    }, wait);
  };
}

export const genID = () => {
  let array = new Uint32Array(8)
  window.crypto.getRandomValues(array)
  let str = ''
  for (let i = 0; i < array.length; i++) {
    str += (i < 2 || i > 5 ? '' : '-') + array[i].toString(16).slice(-4)
  }
  return str
}

export const getResId = (panels, id) => {
  const panel = panels.filter((panel) => panel.id === id);
  if (panel[0]) {
    return panel[0].resId
  } else {
    return undefined
  }
}

export const getChannelName = (channels, channelId) => {
  const channel = channels.filter(channel => channel.id === channelId)
  if (channel[0]) {
    return channel[0].name
  } else {
    return ''
  }
}
