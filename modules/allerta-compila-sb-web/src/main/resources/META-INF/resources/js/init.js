

function initInteract() {

interact('.draggable')
.draggable(
{
						// enable inertial throwing
						inertia : true,
						// keep the element within the area of it's parent
						restrict : {
							restriction : "contenitore",
							endOnly : true,
							elementRect : {
								top : 0,
								left : 0,
								bottom : 1,
								right : 1
							}
						},
						// enable autoScroll
						autoScroll : true,

						// call this function on every dragmove event
						onmove : dragMoveListener,
						// call this function on every dragend event
						onend : function(event) {

							if (event.target.classList.contains("base")) {
								event.target.style.webkitTransform = event.target.style.transform = 'translate('
										+ 0 + 'px, ' + 0 + 'px)';
								event.target.setAttribute('data-x', 0);
								event.target.setAttribute('data-y', 0);

							}

							if (!event.target.classList.contains("can-drop")
									&& !event.target.classList.contains("base")) {

								var rects = [];
								for (k = 0; k < document
										.getElementById("contenitore").childNodes.length; k++) {
									var element = document
											.getElementById("contenitore").childNodes[k];
									if (element == event.target) {
									} else {
										if (element.tagName)
											rects.push(element
													.getBoundingClientRect());
										else
											rects.push(null);
									}
								}

								document.getElementById("contenitore")
										.removeChild(event.target);

								var k;
								var rect = document.getElementById(
										"contenitore").getBoundingClientRect();
								for (k = 0; k < document
										.getElementById("contenitore").childNodes.length; k++) {
									// aggiusta eventuali problemi
									var element = document
											.getElementById("contenitore").childNodes[k];
									if (element.tagName) {
										var rectAltro = element
												.getBoundingClientRect();
										var dataX = parseInt(element
												.getAttribute('data-x'));
										var dataY = parseInt(element
												.getAttribute('data-y'));

										dataX += (rects[k].left - rectAltro.left);
										dataY += (rects[k].top - rectAltro.top);

										element.style.transform = 'translate('
												+ dataX + 'px, ' + dataY
												+ 'px)';
										element.setAttribute('data-x', dataX);
										element.setAttribute('data-y', dataY);
									}

								}

							}

							event.target.classList.remove('can-drop');
							aggiornaTestoMeteo();

						}
					});

	function dragMoveListener(event) {
		var target = event.target,
		// keep the dragged position in the data-x/data-y attributes
		x = (parseFloat(target.getAttribute('data-x')) || 0) + event.dx, y = (parseFloat(target
				.getAttribute('data-y')) || 0)
				+ event.dy;

		// translate the element
		target.style.webkitTransform = target.style.transform = 'translate('
				+ x + 'px, ' + y + 'px)';

		// update the posiion attributes
		target.setAttribute('data-x', x);
		target.setAttribute('data-y', y);
	}

	interact('#contenitore')
			.dropzone(
					{

						accept : '.daicone',
						overlap : 1,

						ondropactivate : function(event) {
							event.target.classList.add('drop-active');
						},

						ondragenter : function(event) {
							var draggableElement = event.relatedTarget, dropzoneElement = event.target;

							// feedback the possibility of a drop
							dropzoneElement.classList.add('drop-target');
							draggableElement.classList.add('can-drop');
						},
						ondragleave : function(event) {
							// remove the drop feedback style
							event.target.classList.remove('drop-target');
							event.relatedTarget.classList.remove('can-drop');
						},

						ondrop : function(event) {
							event.target.classList.remove('drop-active');
							event.target.classList.remove('drop-target');

							element = event.relatedTarget;
							target = event.target

							var drag = event.dragEvent
							var x = drag.clientX
							var y = drag.clientY

							var rect = target.getBoundingClientRect();
							var w = rect.right - rect.left;
							var h = rect.bottom - rect.top;

							var rectAltro = element.getBoundingClientRect();

							var icona;

							if (element.classList.contains('base')) {

								// crea una nuova icona qui
								icona = document.createElement("div");
								var k
								for (k = 0; k < element.classList.length; k++) {
									if (element.classList[k] != 'base'
											&& element.classList[k] != 'can-drop')
										icona.classList
												.add(element.classList[k]);
								}

								target.appendChild(icona);
								var rect2 = icona.getBoundingClientRect();

								icona.style.transform = 'translate('
										+ (rectAltro.left - rect2.left)
										+ 'px, ' + (rectAltro.top - rect2.top)
										+ 'px)';
								// icona.style.backgroundImage =
								// element.style.backgroundImage;
								icona.setAttribute('data-x', rectAltro.left
										- rect2.left);
								icona.setAttribute('data-y', rectAltro.top
										- rect2.top);

							} else
								icona = event.relatedTarget;

							icona.setAttribute('true-x', Math
									.round(rectAltro.left - rect.left));
							icona.setAttribute('true-y', Math
									.round(rectAltro.top - rect.top));

						},
						ondropdeactivate : function(event) {
							// remove active dropzone feedback
							event.target.classList.remove('drop-active');
							event.target.classList.remove('drop-target');
						}
					});

	function getStringaIcone() {

		var con = document.getElementById("contenitore").childNodes;
		var k;
		var s = '';
		for (k = 0; k < con.length; k++) {
			if (con[k].tagName) {
				for (var i = 0; i < con[k].classList.length; i++) {
					if (con[k].classList[i].indexOf('type') > -1)
						s += con[k].classList[i] + '|'
								+ con[k].getAttribute('true-x') + '|'
								+ con[k].getAttribute('true-y') + '|';
				}
			}
		}
		return s;

	}

	function aggiornaTestoMeteo() {
		document.getElementById("testoMeteo").value = getStringaIcone();

	}

	function parseTestoMeteo() {

		var lista = document.getElementById("testoMeteo").value.split('|');
		var target = document.getElementById("contenitore");
		var rect = target.getBoundingClientRect();
		var icona;

		var types = [ 'type1', 'type2', 'type3', 'type4', 'type5', 'type6' ];
		var imgs = [ 'pioggiaassente.png', 'pioggiadebole.png',
				'pioggiamoderata.png', 'pioggiaelevata.png', 'pioggianeve.png',
				'neve.png' ];

		for (var k = 0; k <= lista.length; k += 3) {

			if (lista[k] && lista[k] != '') {

				var url;

				for (var i = 0; i < types.length; i++) {
					if (types[i] == lista[k])
						url = imgs[i];
				}

				var truex = parseInt(lista[k + 1]);
				var truey = parseInt(lista[k + 2]);

				icona = document.createElement("div");
				icona.classList.add('daicone');
				icona.classList.add('draggable');
				icona.classList.add('drag-drop');
				icona.classList.add(lista[k]);
				// icona.style.backgroundImage = 'url(\'../img/' + url + '\')';

				target.appendChild(icona);
				var rect2 = icona.getBoundingClientRect();
				var x = truex + rect.left - rect2.left;
				var y = truey + rect.top - rect2.top;

				icona.style.transform = 'translate(' + x + 'px, ' + y + 'px)';
				icona.setAttribute('data-x', x);
				icona.setAttribute('data-y', y);
				icona.setAttribute('true-x', truex);
				icona.setAttribute('true-y', truey);

			}

		}

	}

	parseTestoMeteo();
}

(function($) {
	

	
	
	if ($("#contenitore").length > 0) {
		initInteract();
	}

})(jQuery);
