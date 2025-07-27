import torch
import cv2

# Load the YOLOv5 model
model = torch.hub.load('ultralytics/yolov5', 'yolov5s', pretrained=True)

# Start video capture
cap = cv2.VideoCapture(0)

while True:
    ret, frame = cap.read()
    if not ret:
        break

    # Convert frame to RGB as OpenCV uses BGR
    img = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Inference
    results = model(img)

    # Render results on the frame
    results.render()
    
    # 'results.imgs' contains the annotated images, take the first one
    annotated_frame = cv2.cvtColor(results.imgs[0], cv2.COLOR_RGB2BGR)

    cv2.imshow("YOLOv5 Detection", annotated_frame)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Cleanup
cap.release()
cv2.destroyAllWindows()

